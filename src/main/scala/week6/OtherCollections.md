Collections tree:

```mermaid
  graph TD;
      Iterable ----> Seq;
      Iterable ---> Set;
      Iterable ---> Map;
      Seq ---> List;
      Seq ---> Range;
      Seq ---> Vector;
      Seq -.-> String;
      Seq -.-> Array;
```