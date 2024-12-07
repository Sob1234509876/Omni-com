Concepts
---

* _Model_ - Do not confuse with the Java module. It acts as a utility architecture and has some clean interfaces.
  Contains
  an interface class or abstract class as it\`s invocation entrance. One can get it\`s implementation class through the
  invocation entrance. Here are some modes one can design :
    * _Interface Provider Mode_ - Here is the format :
      <br>

```text
{ModelName} * Package
+ {SpecificHandlerName} * Package
| + {SpecificHandler} * Class
| \ ...
+ ...
+ {ModelName} * Interface
+ {ModelName}impl * Class
\ Specific{ModelName} * Interface
```