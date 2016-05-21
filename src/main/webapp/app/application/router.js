(function () {
    cadastroSimples.config(function ($routeProvider, $locationProvider) {

//        //Rotas Avulsas
//        $routeProvider.otherwise({
//            redirectTo: '/404'
//        });

        //Rotas 404
//        adicionarRota($routeProvider, '/404', 'app/404/404.html');

        adicionarRota($routeProvider, '/Pessoa', 'app/pessoa/pessoa-cadastro.html', 'controllerPessoaCadastro');
        adicionarRota($routeProvider, '/Pessoa/ee', 'app/pessoa/pessoa-cadastro.html', 'controllerPessoaCadastro');
        adicionarRota($routeProvider, '/Pessoa/Listar', 'app/pessoa/pessoa-listagem.html', 'controllerPessoaListagem');

        adicionarRota($routeProvider, '/Endereco', 'app/endereco/endereco-cadastro.html', 'controllerEnderecoCadastro');
        adicionarRota($routeProvider, '/Endereco/ee', 'app/endereco/endereco-cadastro.html', 'controllerEnderecoCadastro');
        adicionarRota($routeProvider, '/Endereco/Listar', 'app/endereco/endereco-listagem.html', 'controllerEnderecoListagem');


        $locationProvider.html5Mode(false);

    });

    function adicionarRota(routeProvider, rota, urlTemplate, controllerName) {
        routeProvider.when(rota, {
            templateUrl: urlTemplate,
            controller: controllerName
//            resolve: {
//                login: validacaoLogin
//            }
        });
    }

}());
