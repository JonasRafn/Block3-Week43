var app = angular.module('UserApp', ['ngRoute']);

app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/home', {
            templateUrl: 'partials/allpersons.html',
            controller: 'AllUsersController',
            controllerAs: 'ctrl'
        });
        $routeProvider.when('/user/:fname', {
            templateUrl: 'partials/singleperson.html',
            controller: 'UserController',
            controllerAs: 'ctrl'
        });
        $routeProvider.otherwise({
            redirectTo: '/home'
        });
    }]);

app.controller('AllUsersController', ['$http', function ($http) {
        var self = this;
        $http.get('data/data.json').then(function (res) {
            self.users = res.data.users;
            console.log(self.users);
        });
    }]);

app.controller('UserController', ['$http', '$routeParams', function ($http, $routeParams) {
        var self = this;
        $http.get('data/data.json').then(function (res) {
            for (var i = 0; i < res.data.users.length; i++) {
                if (res.data.users[i].first == $routeParams.fname) {
                    self.currentUser = res.data.users[i];
                    console.log(self.currentUser);
                }
            }
        });
    }]);