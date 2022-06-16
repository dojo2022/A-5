'use strict';
// @ts-check
const selectBox = document.querySelector("#change_calendar_menu select")
/** @type {HTMLFormElement} */
const form = document.querySelector("#change_calendar_menu")

selectBox.addEventListener('change', function (event) {
    /** @type {HTMLSelectElement} */
    const select = event.currentTarget
    switch (select.value) {
        case "G":
        case "L":
        case "T":
            form.action = "CalendarServlet" + location.search
            form.submit()
            break;
        default:
            // それ以外は入ってくることは無いはずなので、何もしない
            break;
    }
})