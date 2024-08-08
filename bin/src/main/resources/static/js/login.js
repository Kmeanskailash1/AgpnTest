


document.getElementById('loginBtn').addEventListener('click', async function (event) {

    event.preventDefault(); // Prevent the form from submitting the traditional way
    const userIn = document.getElementById('loginUsername');
    const passIn = document.getElementById('loginPassword');

    //login request to server
    const credentials = {
        user: userIn.value,
        pass: passIn.value
    };
    try {
        const response = await fetch('/login', {
            method: 'POST', // Use the POST method
            headers: {
                'Content-Type': 'application/json' // Indicate that we're sending JSON
            },
            body: JSON.stringify(credentials) // Convert the data object to a JSON string
        });
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const result = await response.text();
        if(result=="success"){
            // On successful login
        sessionStorage.setItem('loggedIn', 'true'); // You could store other user info as needed

            window.location.href = '../dashboard.html';
        }
        else{
            alert('Invalid Credentials, try again.... ');
            window.location.reload();
        }
    } catch (error) {
        console.error('Error:', error);
    }


});