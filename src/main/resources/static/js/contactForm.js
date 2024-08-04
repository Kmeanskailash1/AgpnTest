//contact.html page
document.getElementById('contactPageForm').addEventListener('submit',function(event){
    event.preventDefault(); // Prevent the form from submitting
    const name = document.getElementById("contactFormName");
    const phone = document.getElementById("contactFormPhone");
    const email = document.getElementById("contactFormEmail");
    const msg = document.getElementById("contactFormMessage");
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