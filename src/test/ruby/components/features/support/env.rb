require 'httparty'

ENVIRONMENT = ENV['ENVIRONMENT'] || 'local'
$env = YAML.load_file('./config/environments.yml')[ENVIRONMENT]