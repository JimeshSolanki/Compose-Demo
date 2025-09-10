package com.demo.composeui.ui.model

data class User(
    var name: String,
    var mobileNo: String,
    var isVisibleName: Boolean = true,
    var isVisibleMobileNo: Boolean = true,
)
