# vts-kit-ms-maven-plugin

Feature List:
* [Minio](#Minio)
* [Keycloak](#Keycloak)
* [Gen template API](#Gen-template-API)

Quick start
-------
* Just add the plugin to an existing Spring Boot project
```xml
<plugin>
    <groupId>com.atviettelsolutions</groupId>
    <artifactId>vts-kit-ms-maven-plugin</artifactId>
    <version>1.0.0</version>
</plugin>
```

Usage
-------
#### Minio
```
mvn vts-kit-ms:minio
```
Sau khi chạy lệnh này, dependency của minio cùng với
các properties template sẽ được thêm vào project 
```xml
<dependency>
      <groupId>com.atviettelsolutions</groupId>
      <artifactId>vts-kit-ms-minio-integrated</artifactId>
      <version>1.0.0</version>
</dependency>
```
```yaml
vts:
  minio:
    bucket: <your bucket>
    server: https://<host>:<port>
    secret-key: <your secret key>
    access-key: <your access key>
    auto-create-bucket: true
```
#### Keycloak
```
mvn vts-kit-ms:keycloak
```
Tương tự như minio, sau khi chạy lệnh này keycloak cũng sẽ được thêm vào.
```xml
<dependency>
      <groupId>com.atviettelsolutions</groupId>
      <artifactId>vts-kit-ms-keycloak-auth</artifactId>
      <version>1.0.0</version>
</dependency>
```
```yaml
keycloak:
    resource: <your client id key>
    realm: <your realm name>
    auth-server-url: <url connect to server keycloak>
```
#### Gen template API
```
mvn vts-kit-ms:GenAPI -DfileName=example
```
example.json
```json
{
	"APIs": [
		{
			"method": "Post",
			"URL": "/test/{id}",
			"controllerClass": "BookController",
			"requestBody": "BookDTO",
			"serviceClass" : "BookService",
			"response": "Test"
		}
	],
	"DTOs": [
		{
			"name": "Test",
			"field": [
				{
					"name": "test",
					"type": "String"
				}
			]
		}
	]
}
```
Sau khi chạy lệnh này, các API,DTO  được define trong file example
sẽ được đọc ra và tiến hành gen các tempalte API(controller, service), kèm với
các DTO cũng được gen ra.

BookController.java
```java
@RestController()
@RequestMapping()
public class BookController extends AbstractRestController {
    @PostMapping(path = "/test/{id}")
    public ResponseEntity<Object> test(@PathVariable() String id, BookDTO bookDTO) {
        return RestUtils.responseOk(bookService.test(id, bookDTO));
    }
}
```
BookService.java
```java
public interface BookService {
    Test test(String id, BookDTO bookDTO);
}
```
BookserviceImpl.java
```java
@Service
public class BookServiceImpl implements BookService {

    @Override()
    public Test test(String id, BookDTO bookDTO) {
        return new Test();
    }
}
```
TestDTO.java
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {

    String test;
}

```
Build
-------
* Build with Unittest
```shell script
mvn clean install
```

* Build without Unittest
```shell script
mvn clean install -DskipTests
```
Contribute
-------
Please refer [Contributors Guide](CONTRIBUTING.md)

License
-------
This code is under the [MIT License](https://opensource.org/licenses/MIT).

See the [LICENSE](LICENSE) file for required notices and attributions.