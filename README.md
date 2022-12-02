# 🎄 Advent of Code in Scala

My personal repo to (try to) solve the challenges of the [Advent Of Code](https://adventofcode.com) in Scala.

The repo includes the solutions for all the years starting from 2022.

## Challenges

The challenges for every day are collected (with the related solutions) in [docs](docs) folders structured as

```
docs/
 |
 <year>/
   |
   <day>/
     |
     README.md
```

## Input

Input data for each challenge is stored in the following folders structure:

```
src/main/resources/
 |
 <year>/
   |
   <day>/
     |
     input.txt
```

## Usage (testing)

```bash
# to launch the resolvers for all the implemented years and days
bash bin/launch-all.sh

# to launch the resolvers for all the days of a specific year
bash bin/launch-year.sh <year, e.g. 2022>

# to launch the resolver(s) of a specific year and day
bash bin/launch-year-day.sh <year, e.g. 2022> <day, e.g. 1>
```

[MIT](LICENSE) License
