# Java Martiply Validator

Module to validate inputs to Martiply db


Hosted at Github to take advantage of [Jitpack](https://jitpack.io/).

To test Jitpack build:

```
https://jitpack.io/com/github/martiply/java-martiply-validator/<release version or commit hash>/build.log
```

## Behavior

Required vs non-required

- Input is required: validation will return rule check
- Input is not required and null or empty: validation will return ok
- Input is not required but not empty: validation will return rule check

Return value is nullable

Group check

- Group check has isIgnored. If all inputs are empty then isIgnored is true and these data should not be passed to database insert.
- Group check of required values only returns validated values.
- Group check of non required values may return null.
- If there's no error and isIgnored = false then all these data are safe to pass to database insert.




