# frozen_string_literal: true

Quando('é solicitado a busca da familia da fruta {string}') do |fruit_name|
  @page = FruitFamilyPage.new
  @page.get_family(fruit_name)
end

Entao('status de sucesso {int}') do |status_code|
  expect(@page.response.code).to eql(status_code)
end

Entao('deve ser retornado a familia {string}') do |family_name|
  field_value = JSON.parse(@page.response.body)
  expect(field_value['familyName']).to eql(family_name)
end
