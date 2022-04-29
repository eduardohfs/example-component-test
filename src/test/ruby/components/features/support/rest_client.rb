# frozen_string_literal: true

class RestClient
  include HTTParty

  def initialize(name)
    @name = name
  end

  def get(path, options = {})
    self.class.get(get_url(path), options)
  end

  def post(path, options = {})
    self.class.post(get_url(path), options)
  end

  def patch(path, options = {})
    self.class.patch(get_url(path), options)
  end

  protected

  def get_url(path)
    fragments = $env['services'][@name]
    base = "#{fragments['protocol']}://#{fragments['host']}:#{fragments['port']}"
    URI.join(base, path)
  end
end
