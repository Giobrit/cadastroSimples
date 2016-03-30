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
            Alert("PEssoa salva com sucesso!");
        });
    }

    function buscarEnderecos(){
    console.log("jdididj");
        enderecoService.getEnderecos().then(function(response){
            $scope.enderecos = response.data.data;
            console.log(response.data);
        }).catch(function(){
            console.log("fudeu");
        });
    }
}