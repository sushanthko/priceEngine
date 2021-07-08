/*
Fills form with details of the selected product.
 */
let selectProduct = (productId, products) => {
    if (productId === "") {
        $("#product-form")[0].reset();
        return;
    }
    $(".alert").hide();
    let product = products.find(x => x.id === parseInt(productId));
    $("#units-per-carton").val(product.unitsPerCarton);
    $("#carton-price").val(product.cartonPrice);
    $("#units").val("");
};

/*
Makes a post request to calculate and display the total price.
 */
let postProduct = () => {
    let units = parseInt($("#units").val());
    let product = $("#product option:selected").text();
    let input = JSON.stringify({
        units: units,
        unitsPerCarton: parseInt($("#units-per-carton").val()),
        cartonPrice: parseFloat($("#carton-price").val())
    });

    $.post({
        url: "",
        data: input,
        contentType: "application/json; charset=utf-8",
    })
        .done(data => {
            let $alert = $(".alert");

            $alert.html("The total price of " + units + " unit(s) of " + product +
                " is <strong>" + data + "</strong>.");
            $alert.show();
        })
        .fail(error => {
            console.log(error.responseText);
        });
};

$(document).ready(() => {
    let $productForm = $("#product-form");

    $productForm.submit(event => {
        event.preventDefault();
        postProduct();
    });

    $productForm.bind("reset", () => {
        $(".alert").hide();
    });
});
