<style>
    <%@include file="/css/style.css"%>
</style>

<div class="btn-group btn-group-responsive">
    <button type="button" class="btn btn-primary rounded" data-bs-toggle="modal" data-bs-target="#exampleModal">
        <i class="fa fa-shopping-cart"></i> Cart <span class="badge">0</span>
    </button>
    <!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Lista de pedidos</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                <button type="button" class="btn btn-primary">Pagar</button>
            </div>
        </div>
    </div>
</div>
</div>
