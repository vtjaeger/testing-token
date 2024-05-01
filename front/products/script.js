function getAllProducts(){
    fetch('http://localhost:8080/product', {
        method: 'GET',
        headers : {
            'Content-Type' : 'application/json'
        }
    })
    .then(response => {
        if(!response.ok) {
            console.log("Erro ao obter a lista de produtos");
        }
        return response.json();
    })
    .then(products => {
        console.log("Lista de produtos: ", products);

        const productListElement = document.getElementById('productList');
        productListElement.innerHTML = '';

        products.forEach(product => {
            const card = document.createElement('div');
            card.classList.add('product-card');

            const productName = document.createElement('p');
            productName.textContent = `Name: ${product.name}`; // Corrigido para usar o nome do produto

            const productPrice = document.createElement('p');
            productPrice.textContent = `Price: R$${product.price}`; // Corrigido para usar o preço do produto

            card.appendChild(productName);
            card.appendChild(productPrice);

            productListElement.appendChild(card);
        });
    })
    .catch(error => {
        console.log('Erro ao obter a lista de produtos:', error.message);
    });
}

getAllProducts();
