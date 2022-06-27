'use strict';
//@ts-check

const contextButtons = document.getElementsByClassName('context_button')

// 全てのコンテキストメニューを閉じる
function closeAllContextMenu() {
    for (let index = 0; index < contextButtons.length; index++) {
        /** @type {HTMLInputElement} */
        const contextButton = contextButtons[index];
        contextButton.checked = false
    }
}

const cpToggle01 = document.getElementById('cp_toggle01')
cpToggle01.addEventListener('change', function (event) {
    /** @type {HTMLInputElement} */
    const target = event.currentTarget
    // 閉じる時、全てのサイドメニューを閉じる
    if (!target.checked) {
        closeAllContextMenu()
    }
})

// サイドメニューが開いている時のコンテキストメニュの開閉処理
// 1. メニューを閉じたか開いたの情報を取っておく
// 2. 全てのメニューを閉じる
// 3. 先ほど取っていた情報を戻す
for (let index = 0; index < contextButtons.length; index++) {
    /** @type {HTMLInputElement} */
    const contextButton = contextButtons[index];
    contextButton.addEventListener('change', function (event) {
        /** @type {HTMLInputElement} */
        const target = event.currentTarget
        const isChecked = target.checked
        if (target.checked) {
            closeAllContextMenu()
        }
        target.checked = isChecked
    })
}