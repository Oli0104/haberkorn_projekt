function allCustomers()
{
    fetch('./customer',
        {
            method:"get"
        })
        .then(response => response.json())
        .then(data => {
            let html = "<table>";
            data.forEach(d => html += `<tr><td>${d.id}</td><td>${d.firstName}</td><td>${d.lastName}</td><td><a href="./subsite?id=${d.id}">link</a></td></tr>`)
            html += "</table>"

            document.getElementById("result").innerHTML = html;
        });
}


function addPerson(id, firstname, lastname)
{
    let data = {
        "id": id,
        "first_name": firstname,
        "last_name": lastname
    }

    fetch('./costumer',
        {
            method:"post",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(data)
        }
        ).then(response => alert(response.status + " " + response.statusText));

}