const { createRequire } = require('module');
const requireUtil = createRequire(require.resolve('../src/utils/'));

// Require `../src/utils/some-tool`
requireUtil('./some-tool');