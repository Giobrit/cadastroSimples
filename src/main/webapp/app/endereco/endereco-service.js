(function() {

'use strict';


  cadastroSimples.service('enderecoService', ['$http', function($http) {

    return {
      getEnderecos: function(){
        return $http.get('/v1/endereco');
      },

      postEndereco: function(endereco){
        return $http.post('/v1/endereco', endereco);
      }

    };

  }]);

})(angular);
