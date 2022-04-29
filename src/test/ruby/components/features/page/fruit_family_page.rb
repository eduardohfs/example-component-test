# frozen_string_literal: true

class FruitFamilyPage
  def get_family(fruit_name)
    request_options = {
      headers: { 'Content-Type' => 'application/json' }
    }
    path = "/fruit/family?fruitName=#{fruit_name}"

    send_request('get', path, request_options)
  end

  def send_request(method, path, options)
    @client ||= RestClient.new('fruit')
    @response = @client.get(path, options)
  end

  def response
    @response
  end
end
