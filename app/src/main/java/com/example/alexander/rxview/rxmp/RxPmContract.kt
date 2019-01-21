package com.example.alexander.rxview.rxmp

import me.dmdev.rxpm.PresentationModel

interface RxPmContract {
    interface View

    interface PresentationModel2 {
        val count: PresentationModel.State<Int>
        val showMessage: PresentationModel.Command<Int>
        val onAddClick: PresentationModel.Action<Unit>
    }
}