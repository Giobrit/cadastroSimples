(function() {

'use strict';


  cadastroSimples.service('pessoaService', function($http) {

    return {
      
      postPessoa: function(pessoa){
        return $http.post( '/v1/pessoa', pessoa);
      }
    };

  });

})(angular);
