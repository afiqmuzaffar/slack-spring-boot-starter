package com.kreait.slack.api.test.group.dialog

import com.kreait.slack.api.group.dialog.DialogMethodGroup

/**
 * Testable implementation of [DialogMethodGroup]
 */
class MockDialogMethodGroup : DialogMethodGroup {

    private val mockDialogMethodGroup = MockDialogOpenMethod()

    override fun open(authToken: String) = mockDialogMethodGroup
}
