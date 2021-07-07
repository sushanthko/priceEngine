let select_product = (productId, products) => {
    let product = products.find(x => x.id === parseInt(productId));
    $("#units-per-carton").val(product.unitsPerCarton);
    $("#carton-price").val(product.cartonPrice);
};