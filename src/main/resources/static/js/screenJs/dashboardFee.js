window.onload  = function(){
    alert('dashboardFee');
}
 // Session work starts above
 const TIMEOUT_DURATION = 2 * 60 * 1000; // 2 minutes in milliseconds

 let timeout;

 function resetTimer() {
   clearTimeout(timeout);
   timeout = setTimeout(logoutUser, TIMEOUT_DURATION);
 }

 function logoutUser() {
   sessionStorage.removeItem('loggedIn');
   window.location.href = '../login.html'; // Redirect to login page
 }

 function handleLogout() {
   clearTimeout(timeout);
   sessionStorage.removeItem('loggedIn');
   window.location.href = '../login.html'; // Redirect to login page
 }

 document.addEventListener('DOMContentLoaded', function() {
   if (sessionStorage.getItem('loggedIn') === 'true') {
     resetTimer();
     document.addEventListener('mousemove', resetTimer);
     document.addEventListener('keypress', resetTimer);
     document.addEventListener('click', resetTimer);
   } else {
     //uncomment below line to start session
     //window.location.href = '../../login.html'; // Redirect to login page if not logged in
   }
 });

 // Example logout button handler
 document.getElementById('logoutButton').addEventListener('click', handleLogout);

// Session work ended above , Dasboard work starts here
