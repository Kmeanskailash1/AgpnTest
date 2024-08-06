// index page js
document.getElementById('indexForm').addEventListener('submit',function(event){
    event.preventDefault(); // Prevent the form from submitting
    const name = document.getElementById("indexFormName");
    const phone = document.getElementById("indexFormPhone");
    const email = document.getElementById("indexFormEmail");
    const msg = document.getElementById("indexFormMsg");
    const errorMessage = document.getElementById('error-message');
     // Regular expression to match exactly 10 digits
     const mobileRegex = /^\d{10}$/;
    try{
     if (mobileRegex.test(phone.value)) {
         errorMessage.textContent = 'Mobile number is valid.';
         errorMessage.style.color = 'green';
         alert("Message sent successfully....");
     } else {
         errorMessage.textContent = 'Please enter a valid 10-digit mobile number.';
         errorMessage.style.color = 'red';
         throw "Error";
         
     }
    }
     catch(error){
        alert('Invalid request.....');
     }
     finally
     {
        console.log(name.value + "\n" + phone.value + "\n" + email.value + "\n" + msg.value);
     }

});



