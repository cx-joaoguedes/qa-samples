import { legacy, $Scope, $timeout } from 'legacy.module';

legacy.module('portfolio').controller('portfolio.defaultPopupCollectionController', ['$scope', '$attrs', function($scope: $Scope, $attrs: Record<string, any>): void {
  
    // wait for the tab to be activated
    $scope.dwfReady.then(() => {
      // wait until data is available

        // sort the array by field specified in option
        if ($scope.options && $scope.options.orderByField) {
          // get field
          const field = $scope.options.orderByField;
          // get order DESC or ASC
          const type = $scope.options.orderByType ? $scope.options.orderByType : 'ASC';
          $scope._dataArray.sort((a, b) => {
            // sort
            return a[field] && b[field] && (type == 'DESC' ? a[field] < b[field] : a[field] > b[field]);
          });
        }

      }, true);
}]);
