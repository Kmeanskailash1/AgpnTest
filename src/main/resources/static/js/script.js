
document.getElementById('indexFormSendBtn').addEventListener('click', async function (event) {

    //sendMail
    const mailData = {

        "name": document.getElementById('indexFormName').value,
        "phone": document.getElementById('indexFormPhone').value,
        "email": document.getElementById('indexFormEmail').value,
        "message": document.getElementById('indexFormMsg').value
    };

    const errorMessage = document.getElementById('err-message');
    document.getElementById('indexFormSendBtn').classList.add('disabled');
    // Regular expression to match exactly 10 digits
    const mobileRegex = /^\d{10}$/;

    if (mobileRegex.test(mailData.phone) && mailData.name != '' && mailData.message != '') {

        const response = await fetch('/sendMail', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json' // Indicate that we're sending JSON
            },
            body: JSON.stringify(mailData) // Convert the data object to a JSON string
        });

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        console.log(mailData);
        const result = await response.text();
        alert(result);
        window.location.reload();
    }
    else {
        if (mobileRegex.test(mailData.phone) && parseInt(mailData.phone.trim().substring(0,1))>5)  {
            errorMessage.textContent = 'Mobile number is valid';
            errorMessage.style.color = 'green';

        }
        else {

            errorMessage.textContent = 'Please enter a valid 10-digit mobile number.';
            errorMessage.style.color = 'red';
        }
        alert('Something wrong. ')

    }


});





