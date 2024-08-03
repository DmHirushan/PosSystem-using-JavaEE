// Select the button using its ID
const button = document.getElementById('btn-save-customer');

// Add the event listener to the button
button.addEventListener('click', handleClick);

// Define the function that will be executed when the button is clicked
function handleClick() {
    // alert('Button was clicked!');
    let id = document.getElementById('CustomerId').value;
    let name = document.getElementById('CustomerName').value;
    let address = document.getElementById('CustomerAddress').value;
    let salary = document.getElementById('CustomerSalary').value;
    // console.log(id, name, address, salary);

    const customerData = {
        id : id,
        name : name,
        address : address,
        salary : salary
    }
    console.log(customerData);

    const customerJSON = JSON.stringify(customerData);

    //AJAX
    const http = new XMLHttpRequest();
    http.onreadystatechange = () => {
        if(http.readyState == 4){
            if(http.status == 201){

            }else{

            }
        }else{

        }
    };

    http.open("POST", "http://localhost:8080/pos/customer", true);
    http.setRequestHeader("Content-type", "application/json");
    http.send(customerJSON);

}


