cadastroSimples.controller("controllerEnderecoCadastro", funcaoControllerEnderecoListagem);

cadastroSimples.controller("controllerEnderecoListagem", funcaoControllerEnderecoListagem);

function funcaoControllerEnderecoListagem(){

    $scope.init = function () {
        buscarEnderecos();
    };

    function buscarEnderecos(){
        enderecoService.getEnderecos().then(function(response){
            $scope.enderecos = response.data.data;
            console.log(response.data);
        }).catch(function(){
            console.log("fudeu");
        });
    }
}

function funcaoControllerEnderecoListagem($scope, enderecoService){

    $scope.endereco = {};

    $scope.init = function () {
    };

    $scope.salvar = function (){
        enderecoService.postEndereco($scope.endereco).then(function(){
            console.log("Pessoa salva com sucesso!");
        });
    }

}