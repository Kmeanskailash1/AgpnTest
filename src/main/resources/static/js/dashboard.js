 
  // Session work starts above
  const TIMEOUT_DURATION = 2 * 60 * 1000; // 2 minutes in milliseconds

    let timeout;

    function resetTimer() {
      clearTimeout(timeout);
      timeout = setTimeout(logoutUser, TIMEOUT_DURATION);
    }

    function logoutUser() {
      sessionStorage.removeItem('loggedIn');
      window.location.href = 'login.html'; // Redirect to login page
    }

    function handleLogout() {
      clearTimeout(timeout);
      sessionStorage.removeItem('loggedIn');
      window.location.href = 'login.html'; // Redirect to login page
    }

    document.addEventListener('DOMContentLoaded', function() {
      if (sessionStorage.getItem('loggedIn') === 'true') {
        resetTimer();
        document.addEventListener('mousemove', resetTimer);
        document.addEventListener('keypress', resetTimer);
        document.addEventListener('click', resetTimer);
      } else {
        //uncomment below line to start session
        //window.location.href = 'login.html'; // Redirect to login page if not logged in
      }
    });

    // Example logout button handler
    document.getElementById('logoutButton').addEventListener('click', handleLogout);

  // Session work ended above , Dasboard work starts here
  document.addEventListener('DOMContentLoaded',function(){
    const dasboardAddContainer = document.getElementById('dasboardAddContainer');
    const dasboardViewContainer = document.getElementById('dasboardViewContainer');
    const dasboardDeleteContainer = document.getElementById('dasboardDeleteContainer');
    const dasboardFeeContainer = document.getElementById('dasboardFeeContainer');
    
    dasboardAddContainer.style.display="none";
    dasboardViewContainer.style.display="none";
    dasboardDeleteContainer.style.display="none";
    dasboardFeeContainer.style.display="none";

  });

  document.getElementById('dashBoardViewBtn').addEventListener('click', function(){
    
    dasboardAddContainer.style.display="none";
    dasboardViewContainer.style.display="block";
    dasboardDeleteContainer.style.display="none";
    dasboardFeeContainer.style.display="none";
  });
  document.getElementById('dashBoardAddBtn').addEventListener('click', function(){
    
    dasboardAddContainer.style.display="block";
    dasboardViewContainer.style.display="none";
    dasboardDeleteContainer.style.display="none";
    dasboardFeeContainer.style.display="none";
  });
  document.getElementById('dashBoardDelBtn').addEventListener('click', function(){
    
    dasboardAddContainer.style.display="none";
    dasboardViewContainer.style.display="none";
    dasboardDeleteContainer.style.display="block";
    dasboardFeeContainer.style.display="none";
  });
  document.getElementById('dashBoardFeeBtn').addEventListener('click', function(){
    
    dasboardAddContainer.style.display="none";
    dasboardViewContainer.style.display="none";
    dasboardDeleteContainer.style.display="none";
    dasboardFeeContainer.style.display="block";
  });