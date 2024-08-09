//contact.html page
document.getElementById('contactPageForm').addEventListener('submit',async function(event){
    event.preventDefault(); // Prevent the form from submitting
    
    const errorMessage = document.getElementById('error-message');
     // Regular expression to match exactly 10 digits
     const mobileRegex = /^\d{10}$/;
     const contactMailData = {

        "name": document.getElementById('contactFormName').value,
        "phone": document.getElementById('contactFormPhone').value,
        "email": document.getElementById('contactFormEmail').value,
        "message": document.getElementById('contactFormMessage').value
    };

    try{
       
    
     if (mobileRegex.test(contactMailData.phone)) {
         errorMessage.textContent = 'Mobile number is valid.';
         errorMessage.style.color = 'green';
         const response = await fetch('/sendMail', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json' // Indicate that we're sending JSON
            },
            body: JSON.stringify(contactMailData) // Convert the data object to a JSON string
        });

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        console.log(contactMailData);
        const result = await response.text();
        alert(result);
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
        console.log(contactMailData);
     }

});