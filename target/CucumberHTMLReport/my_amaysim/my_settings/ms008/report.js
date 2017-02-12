$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ms008_auto_recharge.feature");
formatter.feature({
  "id": "ms008---my-settings---auto-recharge",
  "tags": [
    {
      "name": "@my_settings",
      "line": 1
    },
    {
      "name": "@ms008",
      "line": 1
    }
  ],
  "description": "",
  "name": "MS008 - My Settings - Auto Recharge",
  "keyword": "Feature",
  "line": 2
});
formatter.scenarioOutline({
  "id": "ms008---my-settings---auto-recharge;the-user-edits-his/her-auto-recharge-settings",
  "tags": [
    {
      "name": "@ms008_01",
      "line": 9
    }
  ],
  "description": "",
  "name": "The user edits his/her Auto Recharge settings",
  "keyword": "Scenario Outline",
  "line": 10,
  "type": "scenario_outline"
});
formatter.step({
  "name": "the user changes \"\u003cbalance_limit\u003e\" and \"\u003crecharge_sim\u003e\"",
  "keyword": "And ",
  "line": 12
});
formatter.step({
  "name": "the Auto-Recharge should be updated to \"\u003cbalance_limit\u003e\" and \"\u003crecharge_sim\u003e\"",
  "keyword": "Then ",
  "line": 13
});
formatter.examples({
  "id": "ms008---my-settings---auto-recharge;the-user-edits-his/her-auto-recharge-settings;",
  "description": "",
  "name": "",
  "keyword": "Examples",
  "line": 15,
  "rows": [
    {
      "id": "ms008---my-settings---auto-recharge;the-user-edits-his/her-auto-recharge-settings;;1",
      "cells": [
        "balance_limit",
        "recharge_sim"
      ],
      "line": 16
    },
    {
      "id": "ms008---my-settings---auto-recharge;the-user-edits-his/her-auto-recharge-settings;;2",
      "cells": [
        "$10",
        "$50"
      ],
      "line": 17
    }
  ]
});
formatter.background({
  "description": "",
  "name": "",
  "keyword": "Background",
  "line": 4,
  "type": "background"
});
formatter.step({
  "name": "that the user wants to check out his Auto Recharge settings in My Settings menu",
  "keyword": "Given ",
  "line": 6
});
formatter.step({
  "name": "the user clicks on edit Auto-Recharge",
  "keyword": "When ",
  "line": 7
});
formatter.match({
  "location": "MS008_Auto_Recharge.thatTheUserWantsToCheckOutHisAutoRechargeSettingsInMySettingsMenu()"
});
formatter.result({
  "duration": 7351692446,
  "status": "passed"
});
formatter.match({
  "location": "MS008_Auto_Recharge.theUserClicksOnEditAutoRecharge()"
});
formatter.result({
  "duration": 250212255,
  "status": "passed"
});
formatter.scenario({
  "id": "ms008---my-settings---auto-recharge;the-user-edits-his/her-auto-recharge-settings;;2",
  "tags": [
    {
      "name": "@ms008",
      "line": 1
    },
    {
      "name": "@ms008_01",
      "line": 9
    },
    {
      "name": "@my_settings",
      "line": 1
    }
  ],
  "description": "",
  "name": "The user edits his/her Auto Recharge settings",
  "keyword": "Scenario Outline",
  "line": 17,
  "type": "scenario"
});
formatter.step({
  "name": "the user changes \"$10\" and \"$50\"",
  "keyword": "And ",
  "line": 12,
  "matchedColumns": [
    0,
    1
  ]
});
formatter.step({
  "name": "the Auto-Recharge should be updated to \"$10\" and \"$50\"",
  "keyword": "Then ",
  "line": 13,
  "matchedColumns": [
    0,
    1
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "$10",
      "offset": 18
    },
    {
      "val": "$50",
      "offset": 28
    }
  ],
  "location": "MS008_Auto_Recharge.theUserChangesAnd(String,String)"
});
formatter.result({
  "duration": 4758448150,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "$10",
      "offset": 40
    },
    {
      "val": "$50",
      "offset": 50
    }
  ],
  "location": "MS008_Auto_Recharge.theAutoRechargeShouldBeUpdatedToAnd(String,String)"
});
formatter.result({
  "duration": 4245744460,
  "status": "passed"
});
formatter.background({
  "description": "",
  "name": "",
  "keyword": "Background",
  "line": 4,
  "type": "background"
});
formatter.step({
  "name": "that the user wants to check out his Auto Recharge settings in My Settings menu",
  "keyword": "Given ",
  "line": 6
});
formatter.step({
  "name": "the user clicks on edit Auto-Recharge",
  "keyword": "When ",
  "line": 7
});
formatter.match({
  "location": "MS008_Auto_Recharge.thatTheUserWantsToCheckOutHisAutoRechargeSettingsInMySettingsMenu()"
});
formatter.result({
  "duration": 2214417852,
  "status": "passed"
});
formatter.match({
  "location": "MS008_Auto_Recharge.theUserClicksOnEditAutoRecharge()"
});
formatter.result({
  "duration": 5347426453,
  "status": "passed"
});
formatter.scenario({
  "id": "ms008---my-settings---auto-recharge;the-user-disables-his/her-auto-recharge-settings",
  "tags": [
    {
      "name": "@ms008_02",
      "line": 19
    }
  ],
  "description": "",
  "name": "The user disables his/her Auto Recharge settings",
  "keyword": "Scenario",
  "line": 20,
  "type": "scenario"
});
formatter.step({
  "name": "the user clicks on \"No\"",
  "keyword": "And ",
  "line": 22
});
formatter.step({
  "name": "the Auto-Recharge should be disabled",
  "keyword": "Then ",
  "line": 23
});
formatter.match({
  "arguments": [
    {
      "val": "No",
      "offset": 20
    }
  ],
  "location": "MS008_Auto_Recharge.theUserClicksOn(String)"
});
formatter.result({
  "duration": 3799587949,
  "status": "passed"
});
formatter.match({
  "location": "MS008_Auto_Recharge.theAutoRechargeShouldBeDisabled()"
});
formatter.result({
  "duration": 10120417119,
  "status": "passed"
});
formatter.background({
  "description": "",
  "name": "",
  "keyword": "Background",
  "line": 4,
  "type": "background"
});
formatter.step({
  "name": "that the user wants to check out his Auto Recharge settings in My Settings menu",
  "keyword": "Given ",
  "line": 6
});
formatter.step({
  "name": "the user clicks on edit Auto-Recharge",
  "keyword": "When ",
  "line": 7
});
formatter.match({
  "location": "MS008_Auto_Recharge.thatTheUserWantsToCheckOutHisAutoRechargeSettingsInMySettingsMenu()"
});
formatter.result({
  "duration": 2205193853,
  "status": "passed"
});
formatter.match({
  "location": "MS008_Auto_Recharge.theUserClicksOnEditAutoRecharge()"
});
formatter.result({
  "duration": 5419592079,
  "status": "passed"
});
formatter.scenario({
  "id": "ms008---my-settings---auto-recharge;the-user-plans-to-edit-his/her-auto-recharge-settings-then-changes-his/her-mind",
  "tags": [
    {
      "name": "@ms008_03",
      "line": 31
    }
  ],
  "description": "",
  "name": "The user plans to edit his/her Auto Recharge settings then changes his/her mind",
  "keyword": "Scenario",
  "line": 32,
  "type": "scenario",
  "comments": [
    {
      "value": "##",
      "line": 25
    },
    {
      "value": "# Bugs:",
      "line": 26
    },
    {
      "value": "#",
      "line": 27
    },
    {
      "value": "# 1. When Auto Recharge is disabled (No) when clicking on edit",
      "line": 28
    },
    {
      "value": "#    link text, it is set to \u0027Yes\u0027 as default",
      "line": 29
    },
    {
      "value": "##",
      "line": 30
    }
  ]
});
formatter.step({
  "name": "the state should be whatever it is in. (if disabled, it should be on No, if not, then on Yes)",
  "keyword": "Then ",
  "line": 34
});
formatter.match({
  "location": "MS008_Auto_Recharge.theStateShouldBeWhateverItIsInIfDisabledItShouldBeOnNeIfNotThenOnYes()"
});
formatter.result({
  "duration": 4780340426,
  "status": "failed",
  "error_message": "java.lang.AssertionError: Expected: [true] is not equal to Actual: [false]\r\n\tat org.testng.Assert.fail(Assert.java:94)\r\n\tat com.kfm.amaysim_demo.exceptions.AutomationFrameworkException.\u003cinit\u003e(AutomationFrameworkException.java:11)\r\n\tat com.kfm.amaysim_demo.utilities.PageUtility.assertEquals(PageUtility.java:155)\r\n\tat com.kfm.amaysim_demo.utilities.VerificationUtility.assertEquals(VerificationUtility.java:75)\r\n\tat com.kfm.amaysim_demo.base.BaseTest.assertEquals(BaseTest.java:148)\r\n\tat com.kfm.amaysim_demo.scripts.my_amaysim.my_settings.MS008_Auto_Recharge.theStateShouldBeWhateverItIsInIfDisabledItShouldBeOnNeIfNotThenOnYes(MS008_Auto_Recharge.java:62)\r\n\tat ✽.Then the state should be whatever it is in. (if disabled, it should be on No, if not, then on Yes)(ms008_auto_recharge.feature:34)\r\n"
});
formatter.background({
  "description": "",
  "name": "",
  "keyword": "Background",
  "line": 4,
  "type": "background"
});
formatter.step({
  "name": "that the user wants to check out his Auto Recharge settings in My Settings menu",
  "keyword": "Given ",
  "line": 6
});
formatter.step({
  "name": "the user clicks on edit Auto-Recharge",
  "keyword": "When ",
  "line": 7
});
formatter.match({
  "location": "MS008_Auto_Recharge.thatTheUserWantsToCheckOutHisAutoRechargeSettingsInMySettingsMenu()"
});
formatter.result({
  "duration": 2195511641,
  "status": "passed"
});
formatter.match({
  "location": "MS008_Auto_Recharge.theUserClicksOnEditAutoRecharge()"
});
formatter.result({
  "duration": 5891878700,
  "status": "passed"
});
formatter.scenario({
  "id": "ms008---my-settings---auto-recharge;the-user-cancels-auto-recharge-settings-edit",
  "tags": [
    {
      "name": "@ms008_04",
      "line": 36
    }
  ],
  "description": "",
  "name": "The user cancels Auto-Recharge settings edit",
  "keyword": "Scenario",
  "line": 37,
  "type": "scenario"
});
formatter.step({
  "name": "clicks on cancel button",
  "keyword": "And ",
  "line": 39
});
formatter.step({
  "name": "the user should be redirected to My Settings menu",
  "keyword": "Then ",
  "line": 40
});
formatter.match({
  "location": "MS008_Auto_Recharge.clicksOnCancelButton()"
});
formatter.result({
  "duration": 4048958013,
  "status": "passed"
});
formatter.match({
  "location": "MS008_Auto_Recharge.theUserShouldBeRedirectedToMySettingsMenu()"
});
formatter.result({
  "duration": 15141521,
  "status": "passed"
});
});