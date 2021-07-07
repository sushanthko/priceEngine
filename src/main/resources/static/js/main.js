let select_product = (productId, products) => {
    let product = products.find(x => x.id === parseInt(productId));
    $("#units-per-carton").val(product.unitsPerCarton);
    $("#carton-price").val(product.cartonPrice);
};

let postProduct = () => {
    let input = JSON.stringify({
        units: parseInt($("#units").val()),
        unitsPerCarton: parseInt($("#units-per-carton").val()),
        cartonPrice: parseFloat($("#carton-price").val())
    });

    $.post({
        url: "",
        data: input,
        contentType: "application/json; charset=utf-8",
    })
        .done(data => {
            console.log(data);
        })
        .fail(error => {
            console.log(error.responseText);
        });
};

$(document).ready(() => {
    $("#product-form").submit(event => {
        event.preventDefault();
        postProduct();
    });
});
