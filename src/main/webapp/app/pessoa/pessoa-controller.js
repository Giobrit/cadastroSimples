cadastroSimples.controller("controllerPessoaCadastro",  funcaoControllerPessoaCadastro);

cadastroSimples.controller("controllerPessoaListagem", funcaoControllerPessoaListagem);

function funcaoControllerPessoaListagem(){

}

function funcaoControllerPessoaCadastro($scope, enderecoService, pessoaService){
    $scope.enderecos = [];
    $scope.pessoa = {};

    $scope.init = function () {
        buscarEnderecos();
    };

    $scope.salvar = function (){
        pessoaService.postPessoa($scope.pessoa).then(function(){
            console.log("Pessoa salva com sucesso!");
        });
    }

    function buscarEnderecos(){
        enderecoService.getEnderecos().then(function(response){
            $scope.enderecos = response.data.data;
        }).catch(function(){
            console.log("fudeu");
        });
    }
}