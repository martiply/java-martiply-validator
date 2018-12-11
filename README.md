# Java Martiply Validator

Module to validate inputs to Martiply db


Hosted at Github to take advantage of [Jitpack](https://jitpack.io/).

To test Jitpack build:

```
https://jitpack.io/com/github/martiply/java-martiply-validator/<release version or commit hash>/build.log
```

## Behavior

Required vs not-required

- Input is required: validation will return rule check
- Input is not required and null or empty: validation will return ok
- Input is not required but not empty: validation will return rule check

Return value is nullable

Group check has isIgnored. If all inputs are empty then isIgnored is true and these data should not be passed to database insert.






