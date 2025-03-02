let sidebar = document.querySelector('.sidebar');
let isOpen = false;
function openBar() {
  if(!isOpen) {
      sidebar.style.display = 'flex';
      isOpen = true;
   } else {
      sidebar.style.display = 'none';
      isOpen = false;
    }    
}

let myInput = document.getElementById('txt');
let myValue = myInput.value;
let tLabel = document.querySelector('.typingLabel');
let timeout;
myInput.addEventListener('input', () => {
   clearTimeout(timeout);
   tLabel.innerText = 'user is typing';
   tLabel.style.display = 'block';
   tLabel.style.opacity = '1';
   timeout = setTimeout(() => {
      tLabel.style.display = 'none';
   },2000);
});