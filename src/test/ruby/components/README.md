# Component Tests

## Dependencies

* Ruby 2.4.2

### Install bundler

To get started, install the bundler into src/test/ruby/components/:

```bash
exemple-component-test/src/test/ruby/components$ gem install bundler:2.2.27
```

### Project Installation

Then you should be able to run the following command to prepare your environment:

```bash
exemple-component-test/src/test/ruby/components$ bundle install --full-index
```

### Start application:

Run on your Machine (root project path)

```bash
exemple-component-test$ mvn clean install
exemple-component-test$ mvn -Dquarkus.profile=test quarkus:dev
```

## Start test

### Run Dependencies

Using TShield, into src/test/ruby/components/ run:

```bash
exemple-component-test/src/test/ruby/components$ tshield
```

### Run tests

Into src/test/ruby/components/ in second terminal run:

```bash
exemple-component-test/src/test/ruby/components$ cucumber --tags 'not @wip'
```