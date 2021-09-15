package com.example.feature

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.example.add
import com.example.subtract
import io.cucumber.java.Before
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class CalculatorStepDefinition {
    private var firstNumber: Int = 0
    private var secondNumber: Int = 0
    private var actualResult: Int = 0

    @Before
    fun setUp() {
        firstNumber = 0
        secondNumber = 0
        actualResult = 0
    }

    @Given("a integer {int}")
    fun `a integer`(number: Int) {
        firstNumber = number
    }

    @And("a second integer {int}")
    fun `a second integer`(number: Int) {
        secondNumber = number
    }

    @When("the numbers are added")
    fun `the numbers are added`() {
        actualResult = add(firstNumber, secondNumber)
    }

    @When("the numbers are subtracted")
    fun `the numbers are subtracted`() {
        actualResult = subtract(firstNumber, secondNumber)
    }

    @Then("the result is {int}")
    fun `the result is`(expectedResult: Int) {
        assertThat(actualResult).isEqualTo(expectedResult)
    }

}
