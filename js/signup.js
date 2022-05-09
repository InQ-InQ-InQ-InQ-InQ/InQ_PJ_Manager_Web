const openBtn = document.getElementById(".btn")
fetch("https://baconipsum.com/api/?type=all-meat&paras=200&format=html")
  .then(response => response.text())
  .then(result => openBtn.innerHTML = result)

const modal = document.getElementById("modal")
const btnModal = document.getElementById("btn-modal")
btnModal.addEventListener("click", e => {
  modal.style.display = "flex"
})