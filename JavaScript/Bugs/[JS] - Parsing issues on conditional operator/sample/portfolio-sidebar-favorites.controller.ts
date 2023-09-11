import { $Scope, $Element,  legacy } from 'legacy.module';

legacy.module('portfolio').controller('portfolio.sidebarFavoritesController', ['$scope', '$element', '$attrs', function($scope: $Scope, $element: $Element, $attrs: Record<string, any>): void {

  $scope.sortData = (data) => {
    return data.sort((a, b) => {
      const propertyToSearch = { 'Full Name': 'Name', 'Alias': 'NameOrAlias' }[$scope.propertyToShow];
      const dataA = a[propertyToSearch].toUpperCase();
      const dataB = b[propertyToSearch].toUpperCase();
      return dataA < dataB ? -1 : dataA > dataB ? 1 : 0;
    });
  };
  return null;
}]);
