cadastroSimples.controller("controllerEnderecoCadastro", funcaoControllerEnderecoListagem);

cadastroSimples.controller("controllerEnderecoListagem", funcaoControllerEnderecoListagem);

function funcaoControllerEnderecoListagem(){

}

function funcaoControllerEnderecoListagem($scope, enderecoService){


    $scope.init = function () {
        buscarEnderecos();
    };

    function buscarEnderecos(){

    }
}