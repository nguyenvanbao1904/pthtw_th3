function deleteProduct(endpoint, id){
    if(confirm('Are you sure you want to delete this product ?')){
        fetch(`${endpoint}/${id}`, {method: 'delete'}).then( res => {
            if(res.status === 204){
                alert("Product deleted successfully.");
                location.reload();
            }else{
                alert("Product deleted failed.");
            }
        })
    }
}