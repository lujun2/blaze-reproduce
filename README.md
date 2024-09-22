# How to reproduce

After upgrade to Quarkus 3.14+, Blaze
Persistence [Secondary entity view roots](https://persistence.blazebit.com/documentation/1.6/entity-view/manual/en_US/#secondary-entity-view-roots)
mapping doesn't work

* `@Entity TodoTask` is the primary entity, which contains most of the biz logic.
* `@Entity TodoTaskStatistic` contains some statistics logic, and only for display purpose.

This feature works in Quarkus 3.13.3

`./gradlew test --tests '*TodoTaskResourceTest'`

But after upgrade to Quarkus 3.14, this feature is broken

`./gradlew test -PquarkusPluginVersion=3.14.4 -PquarkusPlatformVersion=3.14.4 --tests '*TodoTaskResourceTest'`
