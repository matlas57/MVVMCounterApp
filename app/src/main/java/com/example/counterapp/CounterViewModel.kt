package com.example.counterapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel() : ViewModel() {
    private val _repository: CounterRepository = CounterRepository()
    //Use the model repo to access the model and save the count in VM state
    private val _count = mutableStateOf(_repository.getCounter().count) // _ before variable naming convention

    //Expose private var _count
    val count : MutableState<Int> = _count

    fun increment() {
        _repository.incrementCounter();
        _count.value = _repository.getCounter().count
    }

    fun decrement() {
        _repository.decrementCounter();
        _count.value = _repository.getCounter().count
    }
}