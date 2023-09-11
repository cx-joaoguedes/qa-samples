import { DwfRenderingModes } from '../../dwf/dwf.module';
import { $Scope, $timeout, legacy } from '../../legacy/legacy.module';

legacy.module('portfolio').controller('portfolio.directDealSecuritiesController', ['$scope', '$attrs', function($scope: $Scope, $attrs: Record<string, any>): void {
  // check we are  in edit mode
  if ($scope.renderingMode === DwfRenderingModes.edit) {
    $scope.$on('portfolio-popup-collection-init-item-command', (event, deferred) => {
      if ($scope.model?.directDeal != null) {
        if ($scope.model.directDeal.Domain != null) {
          // resolve promise wtih default domain set
          deferred.resolve({ Domain: legacy.copy($scope.model.directDeal.Domain) });
        }
        else {
          // resolve promise wtih emtpy object
          deferred.resolve({});
        }
      }
    });
  }
  else {
    // wait for the tab to be activated
    $scope.dwfReady.then(() => {
      // wait until data is available
      $scope.$watch($attrs.lcModel, (array) => {
        // check that the array is not empty
        if (Array.isArray(array) && array.length > 0) {
          // initialize dataArray
          const dataArray = [];
          // loop dataArray
          for (let i = 0; i < array.length; i++) {
            // add extended invetmentType
            dataArray.push(jQuery.extend({ ShowFirstRow: false }, array[i]));
            const delayedInit = (el) => {
              $timeout(() => {
                el.ShowFirstRow = false;
              }, 200);
            };
            // this way the xml actions executes
            delayedInit(dataArray[i]);
          }
          // update scope collection
          $scope._dataArray = dataArray;
        }
        else {
          $scope._dataArray = [];
        }
        // sort the array by field specified in option
        if ($scope.options && $scope.options.orderByField) {
          // get field
          const field = $scope.options.orderByField;
          // get order DESC or ASC
          const type = $scope.options.orderByType ? $scope.options.orderByType : 'ASC';
          $scope._dataArray.sort((a, b) => {
            // sort
            // return a[field] && b[field] && (type == 'DESC' ? a[field] < b[field] : a[field] > b[field]);
          });
        }
        // check we have a valid array
        if (Array.isArray(array) && array.length > 0) {
          $scope.FirstRowModel = {
            ShowFirstRow: true,
            Name: $scope._dataArray[0][$scope.options.dataField].Name
          };
        }
        else {
          // no data associated. Create a default new one
          $scope.FirstRowModel = { ShowFirstRow: true, Name: '' };
        }
      }, true);
    });
    // initialize options if needed
    if ($scope.options == null) {
      $scope.options = {};
    }
    // caption
    $scope.options.caption = $scope.options.popupTitle ? $scope.options.popupTitle : '';
    // collection field
    $scope.options.collectionField = '_dataArray';
    // default value field
    $scope.options.defaultValueField = 'FirstRowModel';
  }
}]);
