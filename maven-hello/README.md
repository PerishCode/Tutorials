# maven 学习杂记

## 生命周期

### clean

- pre-clean
- clean
- post-clean

### default

- validate
- initialize
- generate-sources
- process-sources
- generator-resources
- process-resources
- **compile**
- process-classes
- generate-test-sources
- process-test-sources
- generate-test-resources
- process-test-resources
- **test-compile**
- process-test-classes
- **test**
- prepare-package
- package
- pre-integration-test
- integration-test
- post-integartion-test
- verify
- **install**
- **deploy**

### site

- pre-site
- site
- post-site
- site-deploy
