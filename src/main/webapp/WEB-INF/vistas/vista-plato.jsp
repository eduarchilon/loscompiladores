<%@ include file="header.jsp"%>

<style>
    <%@include file="/css/style.css"%>
</style>

<style>
    .border-product{
        border: 2px solid rgb(212, 209, 209);
        border-radius: 10px;
    }
    #main-image{
        width: 350px;
        max-width: 350px;
        max-height: 200px;
        object-fit: cover;
    }
    .card{border:none}
    .product{background-color: #eee}
    .brand{font-size: 13px}
    .act-price{color:red;font-weight: 700}
    .dis-price{text-decoration: line-through}
    .about{font-size: 14px}
    .color{margin-bottom:10px}label
                              .radio{cursor: pointer}label
                                                     .radio input{position: absolute;top: 0;left: 0;visibility: hidden;pointer-events: none}label.radio span{padding: 2px 9px;border: 2px solid #ff0000;display: inline-block;color: #ff0000;border-radius: 3px;text-transform: uppercase}label.radio input:checked+span{border-color: #ff0000;background-color: #ff0000;color: #fff}.btn-danger{background-color: #ff0000 !important;border-color: #ff0000 !important}.btn-danger:hover{background-color: #da0606 !important;border-color: #da0606 !important}.btn-danger:focus{box-shadow: none}.cart i{margin-right: 10px}
</style>

<div class="container-general resto-container mt-1">

    <div class="container mt-5 mb-10 border-product">
        <div class="row d-flex justify-content-center">
            <div class="col-md-10">
                <div class="card">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="images p-3">
                                <div class="text-center p-4"> <img id="main-image" src="https://jumboalacarta.com.ar/wp-content/uploads/2019/06/shutterstock_521741356-1024x684.jpg" width="250" /> </div>
                                <div class="thumbnail text-center"> <img onclick="change_image(this)" src="https://cloudfront-us-east-1.images.arcpublishing.com/eluniverso/CUVKY6OG6NAYZH25RNTYWNBEH4.jpg" width="70"> <img onclick="change_image(this)" src="https://jumboalacarta.com.ar/wp-content/uploads/2019/06/shutterstock_521741356-1024x684.jpg" width="70"> </div>
                            </div>
                        </div>
                        <div class="col-md-6" style="display: flex;">
                            <div class="product p-4">
                                <div class="mt-4 mb-3">
                                    <h5 class="text-uppercase">${platoBuscado.nombre}</h5>
                                    <div class="price d-flex flex-row align-items-center"> <span class="act-price">$${platoBuscado.precio}</span>
<%--                                        <div class="ml-2"> <small class="dis-price">$59</small> <span>40% OFF</span> </div>--%>
                                    </div>
                                </div>
                                <p class="about">${platoBuscado.descripcion}</p>
                                <h6 class="about">Restaurante: ${platoBuscado.restaurante.nombre}</h6>
                                <div class="cart mt-4 align-items-center">
                                    <form  action="/proyecto_limpio_spring_war_exploded/agregar-plato/${platoBuscado.id}" method="post">
                                        <button type="submit" class="btn btn-primary">Agregar al pedido</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

    <script>
        function change_image(image){

            var container = document.getElementById("main-image");

            container.src = image.src;
        }

        document.addEventListener("DOMContentLoaded", function(event) {

        });
    </script>

<%@ include file="footer.jsp"%>