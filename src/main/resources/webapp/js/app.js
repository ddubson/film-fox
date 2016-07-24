angular.module('app', ['ngRoute', 'MoviesModule']).
config(function ($routeProvider, $sceDelegateProvider) {
    $routeProvider.when('/', {
        templateUrl: 'partials/listing.html',
        controller: 'ListMoviesController'
    });

    $routeProvider.when('/search', {
        templateUrl: 'partials/search.html',
        controller: 'SearchMoviesController'
    });

    $routeProvider.otherwise({
        redirectTo: '/'
    });

    $sceDelegateProvider.resourceUrlWhitelist([
      // Allow same origin resource loads.
      'self',
      // Allow loading from our assets domain.  Notice the difference between * and **.
      'http://*.youtube.com/**']);
});

angular.module('MoviesModule', []);