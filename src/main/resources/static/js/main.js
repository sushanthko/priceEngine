let selectProduct = (productId, products) => {
    if (productId === "---SELECT---") {
        $("#product-form")[0].reset();
        return;
    }
    let product = products.find(x => x.id === parseInt(productId));
    $("#units-per-carton").val(product.unitsPerCarton);
    $("#carton-price").val(product.cartonPrice);
};

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
            $(".alert").html("The total price of " + units + " unit(s) of " + product +
                " is <strong>" + data + "</strong>.")
            $(".alert").show();
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

    $("#product-form").bind("reset", () => {
        $(".alert").hide();
    });
});
